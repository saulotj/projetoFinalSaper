import { Route, Routes } from 'react-router-dom';
import { Home } from '../../templates/Home';
import { Login } from '../../templates/Login';
import { NotFound } from '../../templates/NotFound';
import { useContext } from 'react';
import { AuthContext } from '../../store';

export const MainRouter = () => {
    const auth = useContext(AuthContext);

    return (
        <Routes>
            {/* must invert this! */}
            {auth.user ?
                (<>
                    <Route path='/login' element={<Login />}></Route>
                    <Route path='*' element={<NotFound />}></Route>
                </>
                )
                :
                (<>
                <Route path='/agenda' element={<Home />}></Route>
                <Route path='*' element={<NotFound />}></Route>
                </>
                )
            }
        </Routes>
    )
}