import React from "react";

export type User = {};

type AuthProps = {
    user?: User,
    setUser?: (user: User | undefined) => void
};

const defaultValues: AuthProps = {}

export const AuthContext = React.createContext(defaultValues);