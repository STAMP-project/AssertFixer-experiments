
package mage.cards.d;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.BeginningOfUpkeepTriggeredAbility;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.dynamicvalue.common.DomainValue;
import mage.abilities.effects.OneShotEffect;
import mage.abilities.effects.common.cost.CostModificationEffectImpl;
import mage.abilities.keyword.FlyingAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.game.Game;
import mage.game.permanent.Permanent;
import mage.players.Player;
import mage.util.CardUtil;

/**
 *
 * @author Simown
 */
public final class Draco extends CardImpl {

    public Draco(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ARTIFACT,CardType.CREATURE},"{16}");
        this.subtype.add(SubType.DRAGON);
        this.power = new MageInt(9);
        this.toughness = new MageInt(9);

        // Flying
        this.addAbility(FlyingAbility.getInstance());

        // Domain - Draco costs {2} less to cast for each basic land type among lands you control.
        this.addAbility(new SimpleStaticAbility(Zone.STACK, new DracoCostReductionEffect()));

        // Domain - At the beginning of your upkeep, sacrifice Draco unless you pay {10}. This cost is reduced by {2} for each basic land type among lands you control.
        this.addAbility(new BeginningOfUpkeepTriggeredAbility(new DracoSacrificeUnlessPaysEffect(), TargetController.YOU, false));
    }

    public Draco(final Draco card) {
        super(card);
    }

    @Override
    public Draco copy() {
        return new Draco(this);
    }
}

class DracoCostReductionEffect extends CostModificationEffectImpl {

    public DracoCostReductionEffect() {
        super(Duration.WhileOnStack, Outcome.Benefit, CostModificationType.REDUCE_COST);
        staticText = "<i>Domain</i> &mdash; {this} costs {2} less to cast for each basic land type among lands you control.";
    }

    protected DracoCostReductionEffect(final DracoCostReductionEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source, Ability abilityToModify) {
        CardUtil.reduceCost(abilityToModify, new DomainValue(2).calculate(game, source, this));
        return true;
    }

    public boolean applies(Ability abilityToModify, Ability source, Game game) {
        return abilityToModify.getSourceId().equals(source.getSourceId());
    }

    @Override
    public DracoCostReductionEffect copy() {
        return new DracoCostReductionEffect(this);
    }
}

class DracoSacrificeUnlessPaysEffect extends OneShotEffect {

    static final int MAX_DOMAIN_VALUE = 10;

    public DracoSacrificeUnlessPaysEffect () {
        super(Outcome.Sacrifice);
        staticText = "sacrifice {this} unless you pay {10}. This cost is reduced by {2} for each basic land type among lands you control.";
    }

    public DracoSacrificeUnlessPaysEffect (final DracoSacrificeUnlessPaysEffect effect) {
        super(effect);
    }

    @Override
    public boolean apply(Game game, Ability source) {
        Player player = game.getPlayer(source.getControllerId());
        Permanent permanent = game.getPermanent(source.getSourceId());
        if (player != null && permanent != null) {
            // The cost is reduced by {2} for each basic land type.
            int domainValueReduction = new DomainValue(2).calculate(game, source, this);
            int count = MAX_DOMAIN_VALUE - domainValueReduction;
            if (player.chooseUse(Outcome.Benefit, "Pay {" + count + "}? Or " + permanent.getName() + " will be sacrificed.", source, game)) {
                GenericManaCost cost = new GenericManaCost(count);
                if (cost.pay(source, game, source.getSourceId(), source.getControllerId(), false)) {
                    return true;
                }
            }
            permanent.sacrifice(source.getSourceId(), game);
            return true;
        }
        return false;
    }

    @Override
    public DracoSacrificeUnlessPaysEffect copy() {
        return new DracoSacrificeUnlessPaysEffect (this);
    }

}


