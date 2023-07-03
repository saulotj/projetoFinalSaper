import './App.css';
import React, { useState } from 'react';

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
  const [prontuario, setProntuario] = useState('');

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
    setProntuario: prontuario,
  };

  //const enviarDados = (e) => {
  // try {
  //const response = await axios.post('/api/submit', Data);
  // console.log(Data);
  // } catch (error) {
  //  console.error(error);
  //  }
  //}
  const enviarDados = async (e) => {
    try {
      console.log(formData); // Handle the API response
    } catch (error) {
      console.error(error);
    }
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
              type="text"
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
            Telefone
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
        <div className="promotion-form__group">
          <label>
            Número Prontuario
            <input
              type="text"
              value={prontuario}
              onChange={(e) => setProntuario(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-submit">
          <label>
            <input
              id="botton"
              type="submit"
              value="Cadastrar"
              name="Cadastro"
            />
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
