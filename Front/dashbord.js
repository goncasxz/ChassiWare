document.addEventListener("DOMContentLoaded", function () {
  // Alternar entre seções (menu lateral)
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

  // Alternar entre cadastro de produto e funcionário
  

  // Ativar seção Controle de Estoque ao iniciar
  document.getElementById("chassi").classList.add("ativo");
  document.querySelector('[data-section="chassi"]').classList.add("ativo");

  // Funções para cadastro de Chassi
  const formChassi = document.getElementById("form-chassi");
  const listaChassisEstoque = document.getElementById("lista-chassis-estoque");
  const listaChassisOutros = document.getElementById("lista-chassis-outros");
  const selecaoChassi = document.getElementById("selecao-chassi");

  if (formChassi && (listaChassisEstoque || listaChassisOutros) && selecaoChassi) {
    formChassi.addEventListener("submit", function (e) {
      e.preventDefault();

      const codigo = document.getElementById("codigo").value.trim();
      const tipo = document.getElementById("tipo").value.trim();
      const modelo = document.getElementById("modelo").value.trim();
      const ano = parseInt(document.getElementById("ano").value.trim());
      const fabricante = document.getElementById("fabricante").value.trim();
      const localizacao = document.getElementById("localizacao").value.trim();
      const estoque = 0;

      if (!codigo || !tipo || !modelo || !ano || !fabricante || !localizacao) {
        alert("Por favor, preencha todos os campos.");
        return;
      }

      const chassi = { codigo, modelo, tipo, ano, fabricante, localizacao, estoque };

      fetch("http://localhost:8080/chassis/adicionar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(chassi),
      })
        .then((res) => res.json())
        .then((data) => {
          adicionarChassiNaTabela(data);
          adicionarChassiNoSelect(data);
          formChassi.reset();
        })
        .catch((error) => {
          console.error("Erro ao cadastrar chassi:", error);
          alert("Erro ao cadastrar o chassi.");
        });
    });

    // Listar chassis ao carregar
    fetch("http://localhost:8080/chassis/listar")
      .then(res => res.json())
      .then(data => {
        data.forEach(chassi => {
          adicionarChassiNaTabela(chassi);
          adicionarChassiNoSelect(chassi);
        });
      })
      .catch(error => console.error("Erro ao carregar chassis:", error));
  }

  // Adicionar chassi na tabela de estoque e outros
  function adicionarChassiNaTabela(chassi) {
    const tr = document.createElement("tr");
    tr.innerHTML = `
      <td>${chassi.codigo}</td>
      <td>${chassi.tipo}</td>
      <td>${chassi.modelo}</td>
      <td>${chassi.ano}</td>
      <td>${chassi.estoque}</td>
      <td>${chassi.localizacao}</td>
    `;
    listaChassisEstoque.appendChild(tr);

    const trOutros = document.createElement("tr");
    trOutros.innerHTML = `
      <td>${chassi.codigo}</td>
      <td>${chassi.tipo}</td>
      <td>${chassi.modelo}</td>
      <td>${chassi.ano}</td>
      <td>${chassi.fabricante}</td>
      <td>${chassi.localizacao}</td>
    `;
    listaChassisOutros.appendChild(trOutros);
  }

  // Adicionar chassi no select para movimentação
  function adicionarChassiNoSelect(chassi) {
    const option = document.createElement("option");
    option.value = chassi.codigo;
    option.textContent = `${chassi.codigo} | ${chassi.modelo}`;
    selecaoChassi.appendChild(option);
  }

  // Cadastro de Usuário
  const formUsuario = document.getElementById("form-usuario");
  const listaUsuarios = document.getElementById("lista-usuarios");

  if (formUsuario && listaUsuarios) {
    formUsuario.addEventListener("submit", function (e) {
      e.preventDefault();

      const nome = document.getElementById("nome-funcionario").value.trim();
      const email = document.getElementById("email-funcionario").value.trim();
      const senha = document.getElementById("senha-funcionario").value.trim();
      const acesso = document.getElementById("acesso-funcionario").value.trim();

      if (!nome || !email || !senha || !acesso) {
        alert("Preencha todos os campos corretamente.");
        return;
      }

      const tr = document.createElement("tr");
      [nome, email, acesso].forEach(valor => {
        const td = document.createElement("td");
        td.textContent = valor;
        tr.appendChild(td);
      });

      listaUsuarios.appendChild(tr);
      formUsuario.reset();
    });
  }

  // Filtros rápidos
  const botoesFiltro = document.querySelectorAll(".filtros-rapidos button");
  botoesFiltro.forEach(btn => {
    btn.addEventListener("click", () => {
      botoesFiltro.forEach(b => b.classList.remove("ativo"));
      btn.classList.add("ativo");
    });
  });
});

function mostrarCadastro(tipo) {
  const produto = document.getElementById("cadastro-produto");
  const funcionario = document.getElementById("cadastro-funcionario");

  if (tipo === "produto") {
    produto.style.display = "block";
    funcionario.style.display = "none";
  } else {
    produto.style.display = "none";
    funcionario.style.display = "block";
  }
}

window.movimentarEstoque = function () {
  const codigo = document.getElementById("selecao-chassi").value;
  const quantidade = parseInt(document.getElementById("quantidade-mov").value);
  const tipo = document.getElementById("tipo-movimentacao").value;

  if (!codigo || !quantidade || !tipo) {
    alert("Preencha todos os campos da movimentação.");
    return;
  }


  const movimentacao = {
    codigoChassi: codigo,
    quantidade,
    tipoMovimentacao: tipo
  };

  fetch("http://localhost:8080/chassis/movimentacao", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(movimentacao),
  })
    .then(res => res.text()) // Espera resposta no formato de mensagem
    .then((data) => {
      alert(data);
      location.reload(); // Força o refresh da página
      document.getElementById("form-movimentacao").reset();
    })
    .catch(error => {
      console.error("Erro na movimentação:", error);
      alert("Erro ao registrar movimentação.");
    });
};
