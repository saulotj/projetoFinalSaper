import { useEffect, useState } from 'react';
import style from './style.module.scss';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Api } from '../../api/Api';
import { endpointEnum } from '../../enum/api/endpointEnum';

export const Login = () => {
  const [credentials, setCredentials] = useState({user:'', password:''});

  const handleOnChange = (e: any) => {
    setCredentials({ ...credentials, [e.target.name]: e.target.value })
  }

  const handleOnSubmit = (e: any) => {
    e.preventDefault();
    const login = btoa(credentials?.user + ':' + credentials?.password);

    const config = {
      headers: {
        Authorization: 'Basic ' + login,
      }
      
    }
    Api.get(endpointEnum.getRootAdmin, config);
  }

  return (
    <Form className={style.login}>
      <div className={style.loginHeader}>Clínica Saper</div>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>Usuário</Form.Label>
        <Form.Control onChange={(e) => { handleOnChange(e); }} name={'user'} type="text" placeholder="Seu nome de usuário" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Label>Senha</Form.Label>
        <Form.Control onChange={(e) => { handleOnChange(e); }} name={'password'} type="password" placeholder="Sua senha" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="formBasicCheckbox">
        <Form.Check type="checkbox" label="Mantenha me conectado" />
      </Form.Group>
      <Button onClick={(e) => { handleOnSubmit(e) }} variant="primary" type="submit">
        Entrar
      </Button>
    </Form>
  );
}
