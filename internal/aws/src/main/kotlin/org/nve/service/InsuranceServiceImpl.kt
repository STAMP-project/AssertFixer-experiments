package org.nve.service

import org.hibernate.HibernateException
import org.nve.domain.Insurance
import org.nve.exception.ExpectedException
import org.nve.persistence.SessionFactory
import org.nve.persistence.dao.*
import org.nve.services.InsuranceService
import java.sql.Timestamp
import javax.inject.Inject

class InsuranceServiceImpl @Inject constructor(
        private val sessionFactory: SessionFactory
): InsuranceService {

    override fun renew(insurance: Insurance) {
        //TODO: What is this supposed to do?
    }

    override fun read(): Set<Insurance> =
            sessionFactory()
                    .createQuery("from InsuranceEntity as insuranceEntity")
                    .list()
                    .asSequence()
                    .map { toInsurance((it as InsuranceEntity)) }
                    .toSet()

    override fun get(id: Long): Insurance =
            toInsurance(
                    sessionFactory()
                    .use {
                        it.beginTransaction()
                        val compEnt = (it.get(InsuranceEntity::class.java, id))
                        it.transaction.commit()
                        compEnt
                    }
            )

    override fun delete(insurance: Insurance) =
            sessionFactory()
                    .use {
                        try {
                            it.beginTransaction()
                            it.createQuery("delete InsuranceEntity where id = ${insurance.id}")
                                    .executeUpdate()
                            it.transaction.commit()
                            when(insurance) {
                                is Insurance.Bond -> {
                                    it.beginTransaction()
                                    it.createQuery("delete InsuranceBondEntity where id = ${insurance.id}")
                                            .executeUpdate()
                                    it.transaction.commit()
                                }
                                is Insurance.Endorsement -> {
                                    it.beginTransaction()
                                    it.createQuery("delete InsuranceEndorsementEntity where id = ${insurance.id}")
                                            .executeUpdate()
                                    it.transaction.commit()
                                }
                                is Insurance.Policy -> {
                                    //Do nothing. Already deleted.
                                }
                            }
                        }
                        catch (e: HibernateException) {
                            it.transaction.rollback()
                            throw ExpectedException(e, "Error encountered when attempting to delete Company ID: ${insurance.id} in the database")
                        }
                    }

    override fun create(insurance: Insurance) =
            sessionFactory()
                    .use {
                        try {
                            it.beginTransaction()
                            it.save("insurance", toInsuranceEntity(insurance))
                            it.transaction.commit()
                            var result = it.createQuery("select max(id) from InsuranceEntity").list()

                            when(insurance) {
                                is Insurance.Bond -> {
                                    it.beginTransaction()
                                    it.save("insurance_bond", toInsuranceBondEntity(insurance, result.get(0) as Long))
                                    it.transaction.commit()
                                }
                                is Insurance.Endorsement -> {
                                    it.beginTransaction()
                                    it.save("insurance_endorsement", toInsuranceEndorsementEntity(insurance, result.get(0) as Long))
                                    it.transaction.commit()
                                }
                            }
                        }
                        catch (e: HibernateException) {
                            it.transaction.rollback()
                            throw ExpectedException(e, "Error encountered when attempting to add Company ID: ${insurance.id} to the database")
                        }
                    }

    override fun update(original: Insurance, updated: Insurance) =
            sessionFactory()
                    .use {
                        if (original.id != updated.id)
                            throw ExpectedException(IllegalStateException(), "Illegal Update! Original ID: ${original.id}, Updated ID: ${updated.id}")
                        try {
                            it.beginTransaction()
                            it.update("insurance", toInsuranceEntity(updated))
                            it.transaction.commit()
                        }
                        catch (e: HibernateException) {
                            it.transaction.rollback()
                            throw ExpectedException(e, "Error encountered when attempting to update Company ID: ${original.id} in the database")
                        }
                    }

    private fun getEndorsementEntity(endorsementID: Long): InsuranceEndorsementEntity {
        return sessionFactory()
                .use {
                    it.beginTransaction()
                    val compEnt = (it.get(InsuranceEndorsementEntity::class.java, endorsementID))
                    it.transaction.commit()
                    compEnt
                }
    }

    private fun getBondEntity(bondID: Long): InsuranceBondEntity {
        return sessionFactory()
                .use {
                    it.beginTransaction()
                    val compEnt = (it.get(InsuranceBondEntity::class.java, bondID))
                    it.transaction.commit()
                    compEnt
                }
    }

    private fun toInsurance(insuranceEntity: InsuranceEntity) : Insurance {
        when (insuranceEntity.type) {
            "POLICY" -> {
                return Insurance.Policy(
                        id = insuranceEntity.id,
                        number = insuranceEntity.insuranceNumber,
                        terms = Insurance.Terms(
                                id = insuranceEntity.id,
                                effectiveDate = insuranceEntity.termEffectiveDate.toInstant(),
                                expirationDate = insuranceEntity.termExpirationDate.toInstant(),
                                dueDate = insuranceEntity.termDueDate.toInstant()
                        ),
                        endorsements = null //TODO: Populate with list of endorsements
                )
            }

            "ENDORSEMENT" -> {
                return Insurance.Endorsement(
                        id = insuranceEntity.id,
                        number = insuranceEntity.insuranceNumber,
                        terms = Insurance.Terms(
                                id = insuranceEntity.id,
                                effectiveDate = insuranceEntity.termEffectiveDate.toInstant(),
                                expirationDate = insuranceEntity.termExpirationDate.toInstant(),
                                dueDate = insuranceEntity.termDueDate.toInstant()
                        ),
                        policyChange = getEndorsementEntity(insuranceEntity.id)
                                .policyChange
                )
            }
        }

        return Insurance.Bond(
                id = insuranceEntity.id,
                number = insuranceEntity.insuranceNumber,
                terms = Insurance.Terms(
                        id = insuranceEntity.id,
                        effectiveDate = insuranceEntity.termEffectiveDate.toInstant(),
                        expirationDate = insuranceEntity.termExpirationDate.toInstant(),
                        dueDate = insuranceEntity.termDueDate.toInstant()
                ),
                type = if(getBondEntity(insuranceEntity.id).bondType == "MISC")
                    Insurance.Bond.Type.MISC else Insurance.Bond.Type.PERFORMANCE
        )
    }

    private fun toInsuranceEntity(insurance: Insurance): InsuranceEntity {
        val insEnt = InsuranceEntity()
        //insEnt.id = insurance.id
        insEnt.insuranceNumber = insurance.number
        insEnt.termDueDate = Timestamp.from(insurance.terms.dueDate)
        insEnt.termEffectiveDate = Timestamp.from(insurance.terms.effectiveDate)
        insEnt.termExpirationDate = Timestamp.from(insurance.terms.expirationDate)

        when(insurance) {
            is Insurance.Bond -> insEnt.type = "BOND"
            is Insurance.Endorsement -> insEnt.type = "ENDORSEMENT"
            is Insurance.Policy -> insEnt.type = "POLICY"
        }

        return insEnt
    }

    private fun toInsuranceEndorsementEntity(endorsement: Insurance.Endorsement, id: Long? = null): InsuranceEndorsementEntity {
        val endEnt = InsuranceEndorsementEntity()

        endEnt.id = id
        endEnt.insuranceNumber = endorsement.number
        endEnt.policyChange = endorsement.policyChange

        return endEnt
    }

    private fun toInsuranceBondEntity(bond: Insurance.Bond, id: Long? = null): InsuranceBondEntity {
        val bondEnt = InsuranceBondEntity()

        bondEnt.id = id
        bondEnt.insuranceNumber = bond.number
        bondEnt.bondType = bond.type.toString()

        return bondEnt
    }
}