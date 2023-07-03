import './App.css';
import React, { useState } from 'react';

function App() {
  const novosPacientes = 'Agendar Consulta';
  const [nomePaciente, setNomePaciente] = useState('');
  const [data, setData] = useState('');
  const [horario, setHorario] = useState('');
  const [medico, setMedico] = useState('');
  const [convenio, setConvenio] = useState('');
  const [observacoes, setObservacoes] = useState('');

  const formData = {
    nome: nomePaciente,
    data: data,
    horario: horario,
    medico: medico,
    convenio: convenio,
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
            Nome paciente:
            <input
              type="text"
              value={nomePaciente}
              onChange={(e) => setNomePaciente(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label for="date">
            <span id="date-format"> Data consulta</span>
            <input
              type="date"
              aria-describedby="date-format"
              min="2021-03-01"
              max="2031-01-01"
              value={data}
              onChange={(e) => setData(e.target.value)}
            />
          </label>
        </div>

        <div className="promotion-form__group">
          <label>
            Telefone
            <input
              type="text"
              value={horario}
              onChange={(e) => setHorario(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Médico
            <input
              type="text"
              value={medico}
              onChange={(e) => setMedico(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Convenio
            <input
              type="text"
              value={convenio}
              onChange={(e) => setConvenio(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-form__group">
          <label>
            Observações
            <input
              type="text"
              size="50"
              value={observacoes}
              onChange={(e) => setObservacoes(e.target.value)}
            />
          </label>
        </div>

        <div className="promotion-submit">
          <label>
            <input id="botton" type="submit" value="Agendar" name="Agendar" />
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
