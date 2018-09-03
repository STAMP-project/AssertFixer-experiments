package org.nve.service

import com.typesafe.config.Config
import org.nve.domain.Insurance
import org.nve.services.InsuranceService
import java.time.Instant
import javax.inject.Inject
import javax.ws.rs.NotFoundException
import kotlin.LazyThreadSafetyMode.NONE


class LocalInsuranceServiceImpl @Inject constructor(
        val config: Config
): InsuranceService {
    override fun read(): Set<Insurance> =
            insurances.toSet()

    override fun update(current: Insurance, updated: Insurance) {
        insurances.asSequence()
                .toMutableList()
                .remove(current)
        insurances.asSequence()
                .toMutableList()
                .add(updated)
    }

    override fun get(id: Long): Insurance =
            insurances.find { it.id == id } ?: throw NotFoundException("No Insurance found with the id $id")

    override fun create(insurance: Insurance) {
        insurances.asSequence()
                .toMutableList()
                .add(insurance)
    }

    override fun delete(insurance: Insurance) {
        insurances.asSequence()
                .toMutableList()
                .remove(insurances.find { it.id == insurance.id } )
    }

    override fun renew(insurance: Insurance) {
        update(insurance, insurance) // TODO renew will be updated later
    }

    private val insurances: Sequence<Insurance> by lazy(NONE) {
                bonds + endorsements + policies
    }

    private val bonds: Sequence<Insurance.Bond> by lazy(NONE) {
        config.getConfigList("local_insurance.bonds")
                .asSequence()
                .map { toBond(it) }
    }

    private val policies: Sequence<Insurance.Policy> by lazy(NONE) {
        config.getConfigList("local_insurance.policies")
                .asSequence()
                .map { toPolicy(it) }
    }

    private val endorsements: Sequence<Insurance.Endorsement> by lazy(NONE) {
        config.getConfigList("local_insurance.endorsements")
                .asSequence()
                .map { toEndorsement(it) }
    }

    private fun toEndorsement(config: Config): Insurance.Endorsement =
            Insurance.Endorsement(
                    id = config.getLong("id"),
                    number = config.getString("number"),
                    terms = toTerms(config.getConfig("terms")),
                    policyChange = config.getString("policy_change")
            )

    private fun toBond(config: Config): Insurance.Bond =
            Insurance.Bond(
                    id = config.getLong("id"),
                    number = config.getString("number"),
                    terms = toTerms(config.getConfig("terms")),
                    type = Insurance.Bond.Type.valueOf(config.getString("type"))
            )

    private fun toPolicy(config: Config): Insurance.Policy =
            Insurance.Policy(
                    id = config.getLong("id"),
                    number = config.getString("number"),
                    terms = toTerms(config.getConfig("terms")),
                    endorsements = config.getLongList("endorsements")
                            .asSequence()
                            .map { id ->  endorsements.find { it.id == id }!! }
                            .toSet()
            )

    private fun toTerms(config: Config): Insurance.Terms =
            Insurance.Terms(
                    id = config.getLong("id"),
                    effectiveDate = Instant.parse(config.getString("effective_date")),
                    expirationDate = Instant.parse(config.getString("expiration_date")),
                    dueDate = Instant.parse(config.getString("due_date"))
            )
}