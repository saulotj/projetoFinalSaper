import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const novosPacientes = 'Cadastro de Paciente';
  const [nomePaciente, setNomePaciente] = useState('');
  const [nascimento, setNascimento] = useState('');
  const [telefone, setTelefone] = useState('');
  const [responsavel, setResponsavel] = useState('');
  const [cpf, setCpf] = useState('');
  const [endereco, setendereco] = useState('');
  const [estado, setEstado] = useState('');
  const [cidade, setCidade] = useState('');
  const [email, setEmail] = useState('');
  const [errorMessages, setErrorMessages] = useState([]);

  const formData = {
    nome: nomePaciente,
    nascimento: nascimento,
    telefone: telefone,
    responsavel: responsavel,
    cpf: cpf,
    endereco: endereco,
    estado: estado,
    cidade: cidade,
    email: email,
  };

  const enviarDados = async (e) => {
    e.preventDefault();

    // Validate the form data
    const validationErrors = validateFormData(formData);

    if (validationErrors.length > 0) {
      setErrorMessages(validationErrors);
      return;
    }

    try {
      const response = await axios.post('http://localhost:8080/paciente', JSON.stringify(formData), {
        headers: {
          'Content-Type': 'application/json',
        },
      });

      console.log(response.data);
      // Clear the form and error messages
      clearForm();
      setErrorMessages([]);
    } catch (error) {
      console.error(error.response);
    }
  };

  const validateFormData = (formData) => {
    const errors = [];

    if (!formData.cpf) {
      errors.push("CPF is required");
    }

    if (!formData.nascimento) {
      errors.push("Nascimento is required");
    }

    return errors;
  };

  const clearForm = () => {
    setNomePaciente('');
    setNascimento('');
    setTelefone('');
    setResponsavel('');
    setCpf('');
    setendereco('');
    setEstado('');
    setCidade('');
    setEmail('');
  };

  return (
    <div className="App">
      <h1> {novosPacientes}</h1>

      <form onSubmit={enviarDados}>
      <div className="promotion-formgroup">
          <label>
            Nome:
            <input
              type="text"
              value={nomePaciente}
              onChange={(e) => setNomePaciente(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label>
            Nascimento:
            <input
              type="date"
              value={nascimento}
              onChange={(e) => setNascimento(e.target.value)}
            />
          </label>
        </div>

        <div className="promotion-form__group">
          <label>
            Telefone
            <input
              type="text"
              value={telefone}
              onChange={(e) => setTelefone(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Resonsavel
            <input
              type="text"
              value={responsavel}
              onChange={(e) => setResponsavel(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            CPF
            <input
              type="text"
              value={cpf}
              onChange={(e) => setCpf(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Endereco
            <input
              type="text"
              value={endereco}
              onChange={(e) => setendereco(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Estado
            <input
              type="text"
              value={estado}
              onChange={(e) => setEstado(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Cidade
            <input
              type="text"
              value={cidade}
              onChange={(e) => setCidade(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Email
            <input
              type="text"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </label>
        </div>
        {errorMessages.length > 0 && (
          <div className="error-messages">
            {errorMessages.map((errorMessage, index) => (
              <p key={index}>{errorMessage}</p>
            ))}
          </div>
        )}
        <div className="promotion-submit">
          <label>
            <input id="botton" type="submit" value="Cadastrar" name="Cadastro" />
          </label>
        </div>
        <div className="promotion-submit">
          <label>
            <input id="botton" type="submit" value="Cancelar" name="Cancelar" />
          </label>
        </div>
      </form>
    </div>
  );
}

export default App;
