import config from './config.js';

class Crud {
    constructor() {
        this.connection = new config().connection;
    }

    // Create
    create(table, data) {
        return new Promise((resolve, reject) => {
            this.connection.query(`INSERT INTO ${table} SET ?`, data, (err, result) => {
                if (err) {
                    reject(err);
                }
                resolve(result);
            });
        });
    }

    // Read
    read(table, columns, where) {
        return new Promise((resolve, reject) => {
            this.connection.query(`SELECT ${columns} FROM ${table} WHERE ?`, where, (err, result) => {
                if (err) {
                    reject(err);
                }
                resolve(result);
            });
        });
    }

    // Update
    update(table, data, where) {
        return new Promise((resolve, reject) => {
            this.connection.query(`UPDATE ${table} SET ? WHERE ?`, [data, where], (err, result) => {
                if (err) {
                    reject(err);
                }
                resolve(result);
            });
        });
    }

    // Delete
    delete(table, where) {
        return new Promise((resolve, reject) => {
            this.connection.query(`DELETE FROM ${table} WHERE ?`, where, (err, result) => {
                if (err) {
                    reject(err);
                }
                resolve(result);
            });
        });
    }
}