import Axios from "axios";

export const Api = {
    get: async (url: string, config : any) => {
        try {
            const response = await Axios.get(url, config);
            return response;
        } catch(err) {
            console.log(err)
        }
    }
}