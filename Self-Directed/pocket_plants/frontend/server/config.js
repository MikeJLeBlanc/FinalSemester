const SQL = require('mysql');

    const server = 'localhost';
    const username = 'root';
    const password = '';
    const database = 'pocket_plant';

class config {
    constructor() {
        this.connection = SQL.createConnection({
            host: server,
            user: username,
            password: password,
            database: database
        });
    }
}