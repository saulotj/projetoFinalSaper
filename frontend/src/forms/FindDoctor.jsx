import React, { useState } from 'react';
import axios from 'axios';

const FindDoctor = () => {
  const [searchValue, setSearchValue] = useState('');
  const [medico, setMedico] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');
  const [updated, setUpdated] = useState(false);

  const handleSearch = async (e) => {
    e.preventDefault();
    axios.defaults.headers.common['Authorization'] = 'Basic ' + btoa('admin:123');
    axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

    if (!updated) {
      console.log('Please enter a value before searching.');
      return;
    }

    try {
      const response = await axios.get(`http://localhost:8080/medico?nome=${searchValue}&crm=${searchValue}` );

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

  const handleInputChange = (e) => {
    setSearchValue(e.target.value);
    setUpdated(true);
  };

  return (
    <div>
      <form onSubmit={handleSearch}>
        <label>
          Nome ou CRM:
          <input
            type="text"
            value={searchValue}
            onChange={handleInputChange}
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
