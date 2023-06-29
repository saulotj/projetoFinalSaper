import { BrowserRouter } from "react-router-dom";
import { MainRouter } from "./routes/MainRouter";
import { useState } from "react";
import { AuthContext, User } from "./store";

export const App = () => {
    const [user, setUser] = useState<User>();

    return (
        <AuthContext.Provider value={{user, setUser}}>
            <MainRouter />
        </AuthContext.Provider>
    );
}