
package mage.cards.s;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.PutOnLibraryTargetEffect;
import mage.abilities.effects.common.continuous.BoostTargetEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Duration;
import mage.constants.Zone;
import mage.target.common.TargetControlledCreaturePermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LoneFox

 */
public final class SunscapeApprentice extends CardImpl {

    public SunscapeApprentice(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{W}");
        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.WIZARD);
        this.power = new MageInt(1);
        this.toughness = new MageInt(1);

        // {G}, {tap}: Target creature gets +1/+1 until end of turn.
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new BoostTargetEffect(1, 1, Duration.EndOfTurn),
            new ManaCostsImpl("{G}"));
        ability.addCost(new TapSourceCost());
        ability.addTarget(new TargetCreaturePermanent());
        this.addAbility(ability);
        // {U}, {tap}: Put target creature you control on top of its owner's library.
        ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new PutOnLibraryTargetEffect(true),
            new ManaCostsImpl("{U}"));
        ability.addCost(new TapSourceCost());
        ability.addTarget(new TargetControlledCreaturePermanent());
        this.addAbility(ability);
    }

    public SunscapeApprentice(final SunscapeApprentice card) {
        super(card);
    }

    @Override
    public SunscapeApprentice copy() {
        return new SunscapeApprentice(this);
    }
}
