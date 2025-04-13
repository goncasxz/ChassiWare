// Alternar entre seções
const menuItems = document.querySelectorAll(".sidebar li");
const sections = document.querySelectorAll(".section");

menuItems.forEach(item => {
  item.addEventListener("click", () => {
    menuItems.forEach(i => i.classList.remove("ativo"));
    sections.forEach(sec => sec.classList.remove("ativo"));

    item.classList.add("ativo");
    const target = item.getAttribute("data-section");
    document.getElementById(target).classList.add("ativo");
  });
});

// Cadastro de chassis
const form = document.getElementById("form-chassi");
const lista = document.getElementById("lista-chassis");

form.addEventListener("submit", function (e) {
  e.preventDefault();

  const inputs = form.querySelectorAll("input, select");
  const values = Array.from(inputs).map(c => c.value);

  const tr = document.createElement("tr");
  values.forEach(v => {
    const td = document.createElement("td");
    td.textContent = v;
    tr.appendChild(td);
  });

  lista.appendChild(tr);
  form.reset();
});

// Botões rápidos de filtro de período
const botoesFiltro = document.querySelectorAll(".filtros-rapidos button");

botoesFiltro.forEach(btn => {
  btn.addEventListener("click", () => {
    botoesFiltro.forEach(b => b.classList.remove("ativo"));
    btn.classList.add("ativo");
  });
});

const formUsuario = document.getElementById("form-usuario");
const listaUsuarios = document.getElementById("lista-usuarios");

formUsuario.addEventListener("submit", function (e) {
  e.preventDefault();

  const nome = formUsuario.querySelector('input[placeholder="Nome do Usuário"]').value;
  const email = formUsuario.querySelector('input[placeholder="E-mail"]').value;
  const senha = formUsuario.querySelector('input[placeholder="Senha"]').value;
  const acesso = formUsuario.querySelector('select').value;

  // Você pode futuramente salvar a senha no localStorage (criptografada)
  console.log("Usuário cadastrado:", { nome, email, senha, acesso });

  const tr = document.createElement("tr");
  [nome, email, acesso].forEach(texto => {
    const td = document.createElement("td");
    td.textContent = texto;
    tr.appendChild(td);
  });

  listaUsuarios.appendChild(tr);
  formUsuario.reset();
});

