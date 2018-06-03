
package mage.cards.w;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.EndOfCombatTriggeredAbility;
import mage.abilities.common.LeavesBattlefieldTriggeredAbility;
import mage.abilities.effects.common.ExileAllEffect;
import mage.abilities.effects.common.ReturnFromExileEffect;
import mage.abilities.keyword.DefenderAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.BlockedByIdPredicate;

/**
 *
 * @author LoneFox
 */
public final class WallOfNets extends CardImpl {

    public WallOfNets(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{1}{W}{W}");
        this.subtype.add(SubType.WALL);
        this.power = new MageInt(0);
        this.toughness = new MageInt(7);

        // Defender
        this.addAbility(DefenderAbility.getInstance());
        // At end of combat, exile all creatures blocked by Wall of Nets.
        FilterCreaturePermanent filter = new FilterCreaturePermanent("creatures blocked by {this}");
        filter.add(new BlockedByIdPredicate(this.getId()));
        this.addAbility(new EndOfCombatTriggeredAbility(new ExileAllEffect(filter, this.getId(), this.getIdName()), false));
        // When Wall of Nets leaves the battlefield, return all cards exiled with Wall of Nets to the battlefield under their owners' control.
        this.addAbility(new LeavesBattlefieldTriggeredAbility(new ReturnFromExileEffect(this.getId(),
            Zone.BATTLEFIELD, "return all cards exiled with {this} to the battlefield under their owners' control"), false));
    }

    public WallOfNets(final WallOfNets card) {
        super(card);
    }

    @Override
    public WallOfNets copy() {
        return new WallOfNets(this);
    }
}
