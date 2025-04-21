// Seleciona o formulário de login
const loginForm = document.getElementById('login-form');

loginForm.addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio tradicional do formulário

    // Obtém os dados do formulário
    const email = event.target.email.value;
    const senha = event.target.senha.value;

    // Cria o objeto com os dados para enviar ao backend
    const dadosLogin = {
        email: email,
        senha: senha
    };

    // Realiza a requisição para a API de login (backend)
    fetch('http://localhost:8080/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dadosLogin)
    })
    .then(async response => {
        const data = await response.json();
        
        if (response.ok && data.mensagem === "Login bem sucedido") {
            window.location.href = "dashbord.html"; // Login OK
        } else {
            alert(data.mensagem || "Credenciais inválidas");
        }
    })
    .catch(error => {
        console.error('Erro ao realizar login:', error);
        alert('Ocorreu um erro ao tentar fazer login!');
    });
});
