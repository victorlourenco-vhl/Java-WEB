/**
 * Script para validação de formulário
 * @author Victor Lourenço
 */

const validar = () => {
	let nome = formContato.nome.value
	let telefone = formContato.telefone.value

    if(nome === "" || telefone === "") {
        alert('Os campos nome e telefone devem ser preenchidos')
        formContato.nome.focus
        formContato.telefone.focus
        return false
    } else {
        document.forms["formContato"].submit()
    }


}

