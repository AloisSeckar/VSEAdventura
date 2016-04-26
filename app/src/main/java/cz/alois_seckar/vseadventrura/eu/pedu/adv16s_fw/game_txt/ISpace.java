/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;

import java.util.Collection;



/*******************************************************************************
 * Instances of the {@code ISpace} interface represent the spaces in the game.
 *
 * We can take the space visiting as a partial goal,
 * which the player tries to reach.
 * The spaces can be rooms, planets, live stages etc.
 * The spaces can contain various items.that may help user to reach the goal.
 * Each space knows its current neighboring spaces and it knows
 * which items it currently contains.
 * The neighbors as well as the contained items can change during the game.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface ISpace
         extends INamed, IItemContainer
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the collection of current neighbors of this space, i.e. the
     * collection of spaces, to which we can move from this space with the
     * command of the {@link cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE} type.
     *
     * @return Collection of neighbors
     */
//    @Override
    public Collection<? extends ISpace> getNeighbors()
    ;


    /***************************************************************************
     * Returns a collection of items located in the given space.
     *
     * @return Collection of items located in the given space
     */
    @Override
    public Collection<? extends IItem> getItems()
    ;



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
