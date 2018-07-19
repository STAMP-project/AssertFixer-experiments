import { Moment } from 'moment';

export interface ITransaction {
    id?: string;
    characterId?: number;
    date?: Moment;
    transactionId?: number;
    contractId?: number;
    typeId?: number;
    typeName?: string;
    amount?: number;
    pricePerUnit?: number;
    otherParty?: number;
    locationId?: number;
}

export class Transaction implements ITransaction {
    constructor(
        public id?: string,
        public characterId?: number,
        public date?: Moment,
        public transactionId?: number,
        public contractId?: number,
        public typeId?: number,
        public typeName?: string,
        public amount?: number,
        public pricePerUnit?: number,
        public otherParty?: number,
        public locationId?: number
    ) {}
}
