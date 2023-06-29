import style from './style.module.scss';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

export const Login = () => {
  return (
    <Form className={style.login}>
      <div className={style.loginHeader}>Clínica Saper</div>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Usuário</Form.Label>
        <Form.Control type="text" placeholder="Seu nome de usuário" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Senha</Form.Label>
        <Form.Control type="password" placeholder="Sua senha" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicCheckbox">
        <Form.Check type="checkbox" label="Mantenha me conectado" />
      </Form.Group>
      <Button variant="primary" type="submit">
        Entrar
      </Button>
    </Form>
  );
}
