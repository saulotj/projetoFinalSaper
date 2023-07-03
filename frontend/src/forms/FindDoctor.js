<<<<<<< HEAD
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const MedicoSearchForm = () => {
=======
import React, { useState } from 'react';
import axios from 'axios';

const FindDoctor = () => {
>>>>>>> 8d152e1decc8a85905b656c125467a49e6ee6d74
  const [searchValue, setSearchValue] = useState('');
  const [medico, setMedico] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');

<<<<<<< HEAD
  useEffect(() => {
    const searchMedico = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/medicos?name=${searchValue}&crm=${searchValue}`);

        if (response.data.length === 0) {
          setMedico(null);
          setErrorMessage('Médico não cadastrado!');
        } else {
          setMedico(response.data[0]);
          setErrorMessage('Médico não encontrado!');
        }
      } catch (error) {
        console.error(error);
      }
    };

    // Perform search when the searchValue changes
    searchMedico();
  }, [searchValue]);

  const handleSearchChange = (e) => {
    setSearchValue(e.target.value);
=======
  const handleSearch = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.get(`http://localhost:8080/medicos?name=${searchValue}&crm=${searchValue}`);

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
>>>>>>> 8d152e1decc8a85905b656c125467a49e6ee6d74
  };

  return (
    <div>
<<<<<<< HEAD
      <form>
        <label>
          Name or CRM:
          <input
            type="text"
            value={searchValue}
            onChange={handleSearchChange}
          />
        </label>
=======
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
>>>>>>> 8d152e1decc8a85905b656c125467a49e6ee6d74
      </form>

      {errorMessage && <p>{errorMessage}</p>}

      {medico && (
        <div>
          <h2>Medico Details:</h2>
          <p>Name: {medico.name}</p>
<<<<<<< HEAD
          <p>CRM: {medico.crm}</p>
          <p>Especialidade: {medico.especialidade}</p>
          <p>Telefone: {medico.telefone}</p>
=======
          <p>Username: {medico.username}</p>
          <p>CRM: {medico.crm}</p>
          <p>Telefone: {medico.telefone}</p>
          <p>Especialidade: {medico.especialidade}</p>
>>>>>>> 8d152e1decc8a85905b656c125467a49e6ee6d74
        </div>
      )}
    </div>
  );
};

<<<<<<< HEAD
export default MedicoSearchForm;
=======
export default FindDoctor;
>>>>>>> 8d152e1decc8a85905b656c125467a49e6ee6d74
