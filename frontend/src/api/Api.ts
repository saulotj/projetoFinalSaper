import Axios from "axios";

export const Api = {
    get: async (url: string, config : any) => {
        try {
            const response = await Axios.get(url, config);
            console.log(response);
        } catch(err) {
            console.log(err)
        }
    }
}