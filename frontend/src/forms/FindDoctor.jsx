import React, { useState } from 'react';
import axios from 'axios';

const FindDoctor = () => {
  const [searchValue, setSearchValue] = useState('');
  const [medico, setMedico] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');

  const handleSearch = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(
         `http://localhost:8080/medico?nome=${searchValue}&crm=${searchValue}`
        
      );

      if (response.data.length === 0) {
        setMedico(null);
        setErrorMessage('Médico não cadastrado');
      } else {
        setMedico(response.data[0]);
        setErrorMessage('');
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSearch}>
        <label>
          Nome ou CRM:
          <input
            type="text"
            value={searchValue}
            onChange={(e) => setSearchValue(e.target.value)}
          />
        </label>
        <button type="submit">Buscar</button>
      </form>

      {errorMessage && <p>{errorMessage}</p>}

      {medico && (
        <div>
          <h2>Medico Details:</h2>
          <p>Name: {medico.name}</p>
          <p>Username: {medico.username}</p>
          <p>CRM: {medico.crm}</p>
          <p>Telefone: {medico.telefone}</p>
          <p>Especialidade: {medico.especialidade}</p>
        </div>
      )}
    </div>
  );
};

export default FindDoctor;
