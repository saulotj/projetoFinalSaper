import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import style from './style.module.scss';
import { useNavigate } from 'react-router';
import { useContext } from 'react';
import { ConsultaContext } from '../../../store/ConsultaContext';

export const ConsultaView = () => {
    const navigate = useNavigate();
    const dados = useContext(ConsultaContext);
    const consulta = dados.consulta;
    const medico = dados.medico;
    const paciente = dados.paciente;
    const recepcionista = dados.recepcionista;

    const handleGoBack = () => {
        navigate('/agenda/semana');
    }

    console.log(consulta, medico, paciente, recepcionista);

    return (
        <Form className={style.consultaView}>
            <Row className="mb-3">
                <Form.Group as={Col} controlId="formGridEmail1">
                    <Form.Label>Paciente</Form.Label>
                    <Form.Control type="text" placeholder={paciente?paciente.nome:'Carregando'} disabled={true}/>
                </Form.Group>

                <Form.Group as={Col} controlId="formGridPassword1">
                    <Form.Label>Médico</Form.Label>
                    <Form.Control type="password" placeholder={medico?medico.nome:'Carregando'} disabled={true}/>
                </Form.Group>
            </Row>

            <Row className="mb-3">
                <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>Horário</Form.Label>
                    <Form.Control type="text" placeholder={consulta?consulta.horario:'Carregando'} disabled={true}/>
                </Form.Group>

                <Form.Group as={Col} controlId="formGridPassword">
                    <Form.Label>Data</Form.Label>
                    <Form.Control type="text" placeholder={consulta?consulta.data:'Carregando'} disabled={true}/>
                </Form.Group>
            </Row>

            <Form.Group className="mb-3" controlId="formGridAddress1">
                <Form.Label>Observações</Form.Label>
                <Form.Control placeholder={consulta?consulta.observacao:'Carregando'} disabled={true}/>
            </Form.Group>

            <Row className="mb-5">
                <Form.Group as={Col} controlId="formGridCity">
                    <Form.Label>Hora do Atendimento</Form.Label>
                    <Form.Control disabled={true} placeholder={consulta?consulta['atendimento_at']:''}/>
                </Form.Group>

                <Form.Group as={Col} controlId="formGridState">
                    <Form.Label>Status</Form.Label>
                    <Form.Select defaultValue='' disabled={true}>
                        <option>{consulta?consulta.status:'--'}</option>
                        <option>...</option>
                    </Form.Select>
                </Form.Group>

                <Form.Group as={Col} controlId="formGridZip">
                    <Form.Label>Horário de Chegada</Form.Label>
                    <Form.Control disabled={true} placeholder={consulta?consulta['chegada_at']:'--'}/>
                </Form.Group>
            </Row>

            <Row className={style.row}>
                <Form.Group className={style.column} as={Col}>
                    <Button variant="warning" onClick={() => {handleGoBack()}}>
                        Voltar
                    </Button>
                </Form.Group>
                <Form.Group className={style.column} as={Col}>
                    <Button variant="primary">
                        Editar
                    </Button>
                </Form.Group>
            </Row>
        </Form>
    );
}
