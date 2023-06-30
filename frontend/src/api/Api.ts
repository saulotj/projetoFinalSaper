import Axios from "axios";

export const Api = {
    get: async (url: string, config: any) => {
        try {
            const response = await Axios.get(url, config);
            return response;
        } catch (err) {
            console.log(err)
        }
    },
    all: (endpoints: string[], config: any) => {
        try {
            Axios.all(endpoints.map((endpoint) => {
                Axios.get(endpoint, config).then((data) => {
                    return data;
                })
            }))
        } catch (err) {
            console.log(err);
        }
    }
}