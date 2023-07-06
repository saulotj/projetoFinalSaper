import React, { useState } from 'react';

const LoginForm = () => {
  const [usuario, setUsuario] = useState('');

  const [password, setPassword] = useState('');

  const handleUsuarioChange = (e) => {
    setUsuario(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Aqui você pode add a lógica para autenticar o usuário
    console.log('Usuario:', usuario);
    console.log('Password:', password);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Usuario:</label>
        <input type="text" value={usuario} onChange={handleUsuarioChange} />
      </div>
      <div>
        <label>Password:</label>
        <input type="password" value={password} onChange={handlePasswordChange} />
      </div>
      <button type="submit">Login</button>
    </form>
  );
};

export default LoginForm;

