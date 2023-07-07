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

  const enviarDados = async (e) => {
    e.preventDefault();
    try {
      console.log(formData);
      // Chame a função de envio para a API aqui
    } catch (error) {
      console.error(error);
    }
  };

  const handleCancelar = () => {
    // Implemente a lógica para cancelar aqui
    // Por exemplo, limpar os campos do formulário
    setNomePaciente('');
    setData('');
    setHorario('');
    setMedico('');
    setConvenio('');
    setObservacoes('');
  };

  return (
    <div className="App">
      <h1>{novosPacientes}</h1>

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
          <label>
            Data:
            <input
              type="date"
              value={data}
              onChange={(e) => setData(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label>
            Horario:
            <input
              type="time"
              value={horario}
              onChange={(e) => setHorario(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label>
            Medico
            <input
              type="text"
              value={medico}
              onChange={(e) => setMedico(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label>
            Convenio
            <input
              type="text"
              value={observacoes}
              onChange={(e) => setConvenio(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-formgroup">
          <label>
            Observações:
            <input
              type="text"
              value={nomePaciente}
              onChange={(e) => setObservacoes(e.target.value)}
            />
          </label>
        </div>
        <div className="promotion-submit">
          <button type="submit">Agendar</button>
        </div>
        <div className="promotion-submit">
          <button type="button" onClick={handleCancelar}>
            Cancelar
          </button>
        </div>
      </form>
    </div>
  );
}

export default App;