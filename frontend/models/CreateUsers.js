import './App.css';
import React, { useState } from 'react';

function App() {
  const novosUsuarios = 'Novos Usuarios';
  const [name1, setName] = useState('');
  const [email, setEmail] = useState('');

  const [senha, setSenha] = useState('');

  const formData = {
    name: name1,
    email: email,

    senha: senha,
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
      <h1> {novosUsuarios}</h1>

      <form onSubmit={enviarDados}>
        <div className="promotion-formgroup">
          <label>
            Nome
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
        <div className="promotion-submit">
          <label>
            <input
              id="botton"
              type="submit"
              value="Criar Usuario"
              name="tipoUsuario"
            />
          </label>
        </div>
      </form>
    </div>
  );
}

export default App;
