function irParaHome() {
	location.href = "/";
}

function addIngrediente() {
	let ingrediente = document.getElementById("ingrediente");
	if (ingrediente.value !== "") {
		ingrediente.classList.remove("is-invalid");
		let html = "<tr>"
			+ "<td>"
			+ "<input type=\"hidden\" name=\"adicionais[" + document.getElementsByTagName("tr").length + "].id\" value=\"" + ingrediente.value + "\">"
			+ ingrediente.options[ingrediente.selectedIndex].text
			+ "</td>"
			+ "<td>"
			+ "<button type=\"button\" onclick=\"removerIngrediente(this)\" class=\"btn btn-warning font-weight-bold\">"
			+ "Remover"
			+ "</button>"
			+ "</td>"
			+ "</tr>";
		document.getElementById("ingredientes").innerHTML = document.getElementById("ingredientes").innerHTML + html;
	} else {
		ingrediente.classList.add("is-invalid");
	}
}

function removerIngrediente(button) {
	button.parentElement.parentElement.outerHTML = "";
}

function enviarPedido() {
	let lanche = document.getElementById("lanche");
	if (lanche.value !== "") {
		lanche.classList.remove("is-invalid");
		document.getElementById("form-pedido").submit();
	} else {
		lanche.classList.add("is-invalid");
	}
}