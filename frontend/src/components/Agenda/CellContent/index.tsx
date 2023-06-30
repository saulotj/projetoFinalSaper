import { useContext, useState } from 'react';
import style from './style.module.scss';
import { useNavigate } from 'react-router';
import { ConsultaContext } from '../../../store/ConsultaContext';
import { Api } from '../../../api/Api';
import { ApiConfig } from '../../../api/ApiConfig';
import { endpointEnum } from '../../../enum/api/endpointEnum';

export const CellContent = ({ content }: any) => {
    const [status, setStatus] = useState(content.status);
    const dados = useContext(ConsultaContext);
    const navigate = useNavigate();

    const handleClick = async () => {
        const response: any = await Api.get(content.url, ApiConfig.getHeaderDevAccess());
        const consulta = response?.data;
        const medicoResponse = await Api.get(endpointEnum.getMedicoById(consulta['medico_id']), ApiConfig.getHeaderDevAccess());
        const pacienteResponse = await Api.get(endpointEnum.getPacienteById(consulta['paciente_id']), ApiConfig.getHeaderDevAccess());
        const recepcionistaResponse = await Api.get(endpointEnum.getRecepById(consulta['recepcionista_id']), ApiConfig.getHeaderDevAccess());

        dados.setConsulta(consulta);
        dados.setMedico(medicoResponse?.data);
        dados.setPaciente(pacienteResponse?.data);
        dados.setRecepcionista(recepcionistaResponse?.data);
        
        navigate(`/agenda/consulta/${content.id}`);
    }

    return (
        <div onClick={() => { handleClick() }} className={`${style.cellConsulta} ${style[status]}`}>
            {content.id}
        </div>
    )
}