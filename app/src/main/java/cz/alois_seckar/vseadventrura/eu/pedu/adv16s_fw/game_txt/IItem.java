/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt;



/*******************************************************************************
 * Instances of the {@code IItem} interface represent the items in spaces.
 * These items can be things as well as persons or other entities
 * (flowers, light, charm etc.)
 * <p>
 * Some of these items can qualify certain game or space properties
 * (the light is on), others may be determined for taken and so gain a property
 * (e.g. ability to go through a strange space), or capability
 * (e.g. key for unlocking the door, sward for killing the monster,
 * money for bribing the guard etc.),
 * <p>
 * You can define items which serve simultaneously as spaces and can
 * therefore contain other items (e.g. safe, window etc.).
 * You have to enter in these items/spaces with a special command
 * (e.g. <i>open safe</i>, <i>look_from window</i>, etc.) and leave them with
 * another special command (e.g. <i>close safe</i>, <i>shut window</i> etc.).
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface IItem
         extends INamed
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Returns the item weight, and/or the corresponding characteristics.
     * The items that cannot be raised
     * have higher weight than the bag capacity is.
     *
     * @return Weight of the item
     */
//    @Override
    public int getWeight()
    ;



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
