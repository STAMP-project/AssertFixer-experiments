
package mage.cards.f;

import java.util.UUID;
import mage.abilities.common.CastOnlyDuringPhaseStepSourceAbility;
import mage.abilities.condition.common.OnOpponentsTurnCondition;
import mage.abilities.effects.common.combat.CantAttackAnyPlayerAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.PhaseStep;
import static mage.filter.StaticFilters.FILTER_PERMANENT_CREATURES;

/**
 *
 * @author escplan9 (Derek Monturo - dmontur1 at gmail dot com)
 */
public final class Festival extends CardImpl {

    public Festival(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{W}");

        // Cast Festival only during an opponent's upkeep.
        this.addAbility(new CastOnlyDuringPhaseStepSourceAbility(null, PhaseStep.UPKEEP, OnOpponentsTurnCondition.instance,
                "Cast {this} only during an opponent's upkeep"));

        // Creatures can't attack this turn.
        this.getSpellAbility().addEffect(new CantAttackAnyPlayerAllEffect(Duration.EndOfTurn, FILTER_PERMANENT_CREATURES));

    }

    public Festival(final Festival card) {
        super(card);
    }

    @Override
    public Festival copy() {
        return new Festival(this);
    }
}
