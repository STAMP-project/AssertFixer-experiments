import { Moment } from 'moment';

export interface ITax {
    id?: string;
    characterId?: number;
    date?: Moment;
    amount?: number;
    description?: string;
    journalId?: number;
    tax?: number;
    taxReceiverId?: number;
}

export class Tax implements ITax {
    constructor(
        public id?: string,
        public characterId?: number,
        public date?: Moment,
        public amount?: number,
        public description?: string,
        public journalId?: number,
        public tax?: number,
        public taxReceiverId?: number
    ) {}
}
