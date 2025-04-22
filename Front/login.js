
const loginForm = document.getElementById('login-form');

loginForm.addEventListener('submit', function(event) {
    event.preventDefault(); 


    const email = event.target.email.value;
    const senha = event.target.senha.value;


    const dadosLogin = {
        email: email,
        senha: senha
    };


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
            window.location.href = "dashbord.html"; 
        } else {
            alert(data.mensagem || "Credenciais inválidas");
        }
    })
    .catch(error => {
        console.error('Erro ao realizar login:', error);
        alert('Ocorreu um erro ao tentar fazer login!');
    });
});
