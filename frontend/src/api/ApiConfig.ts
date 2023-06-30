export class ApiConfig {
    static getHeaderWithBasicLogin(login: string) {
        return {
            headers: {
                Authorization: 'Basic ' + login
            }
        }
    }

    static getHeaderDevAccess() {
        return {
            headers: {
                Authorization: 'Basic ' + 'YWRtaW46MTIz'
            }
        }
    }
}