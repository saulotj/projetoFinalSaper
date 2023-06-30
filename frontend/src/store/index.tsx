import React from "react";

export type User = {};

type AuthProps = {
    user?: any,
    setUser?: (user: User | undefined) => void,
    credentials?: any,
    setCredentials?:(credential: any) => void
};

const defaultValues: AuthProps = {}

export const AuthContext = React.createContext(defaultValues);