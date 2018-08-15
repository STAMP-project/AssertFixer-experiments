
package mage.cards.s;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.dynamicvalue.common.PermanentsOnBattlefieldCount;
import mage.abilities.effects.common.continuous.SetPowerToughnessSourceEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SubType;
import mage.constants.Zone;
import mage.filter.common.FilterControlledPermanent;
import mage.filter.predicate.mageobject.SubtypePredicate;

/**
 *
 * @author LevelX2
 */
public final class SquelchingLeeches extends CardImpl {

    private static final FilterControlledPermanent filter = new FilterControlledPermanent("Swamps you control");

    static {
        filter.add(new SubtypePredicate(SubType.SWAMP));
    }
    
    public SquelchingLeeches(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{2}{B}{B}");
        this.subtype.add(SubType.LEECH);

        this.power = new MageInt(0);
        this.toughness = new MageInt(0);

        // Squelching Leeches's power and toughness are each equal to the number of Swamps you control.
        this.addAbility(new SimpleStaticAbility(Zone.ALL, new SetPowerToughnessSourceEffect(new PermanentsOnBattlefieldCount(filter), Duration.EndOfGame)));
    }

    public SquelchingLeeches(final SquelchingLeeches card) {
        super(card);
    }

    @Override
    public SquelchingLeeches copy() {
        return new SquelchingLeeches(this);
    }
}
