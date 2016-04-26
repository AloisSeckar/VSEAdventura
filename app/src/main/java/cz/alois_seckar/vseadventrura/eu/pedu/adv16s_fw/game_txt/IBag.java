/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;

import java.util.Collection;



/*******************************************************************************
 * Instance of the {@code Bag} interface represents the repository,
 * to which the players store the items picked up in individual spaces,
 * so that they could be moved to other spaces and/or used.
 * The disposal site has a final capacity defining the maximal permitted
 * sum of weights of items occuring in the repository.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IBag
         extends IItemContainer
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the bag capacity, i.e. the maximal permitted sum
     * of weights of items, that can be put into the bag at the same time.
     *
     * @return Capacity of the bag
     */
//    @Override
    public int getCapacity()
    ;


    /***************************************************************************
     * Returns the collection of items saved in the bag.
     *
     * @return Collection of items in the bag
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
