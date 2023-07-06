import './App.css';
import React, { useState } from 'react';
import { AgendarConsulta } from './components/agendarConsulta';

function App() {
  const redefiniSenha = 'Redefinir Senha';
  const [name1, setName] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [senha2, setSenha2] = useState('');

  const formData = {
    name: name1,
    email: email,
    senha: senha,
    senha2: senha2,
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
      <h1> {redefiniSenha}</h1>

      <form onSubmit={enviarDados}>
        <div className="promotion-formgroup">
          <label>
            Usuário
            <input
              type="text"
              value={name1}
              onChange={(e) => setName(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label>
            E-mail
            <input
              type="text"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </label>
        </div>

        <div className="promotion-form__group">
          <label>
            Senha
            <input
              type="password"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Confirmar Senha
            <input
              type="password"
              value={senha2}
              onChange={(e) => setSenha2(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-submit">
          <label>
            <input id="botton" type="submit" value="Redefinir senha" />
          </label>
        </div>
      </form>
    </div>
  );
}

export default App;
