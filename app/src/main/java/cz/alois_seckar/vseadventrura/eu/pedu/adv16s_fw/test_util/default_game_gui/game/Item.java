/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui.IItemG;

import static cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.test_util.default_game_gui.game.Texts.*;



/*******************************************************************************
 * {@code Item} instances represent the items in spaces.
 * In this game the item <i>ice-box</i> is at the same time the space.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class Item extends ANamed implements IItemG
{
//== CONSTANT CLASS FIELDS =====================================================

    /** The weight of non-portable items. */
    private static final int HEAVY = Hands.CAPACITY + 1;

    /** The indicator of a standard portable item. */
    static final char STANDARD = '1';

    /** The indicator of necessity to use both hands for raising the item up. */
    static final char DOUBLE_HAND = '2';

    /** The indicator of non-portability of the item. */
    static final char NOT_MOVABLE = '#';

    /** The indicator of alcoholic drink. */
    static final char ALCOHOL = '@';



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================

    /** Weight of the item. */
    private final int weight;

    /** If it is the alcoholic drink. */
    private final boolean isAlcoholic;



//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Creates the item with the given name and other given properties.
     * These additional properties are entered through a prefix,
     * that is the first character of the given name.
     * The name of the item itself is created by the remaining letters.<br>
     * the prefix sings have the following meaning:<br>
     *
     *
     * @param name The name of the created item
     */
    Item(String name)
    {
        super(name.substring(1));

        boolean alcoholic      = false;
        int     estimatedWight = 1;
        char    prefix         = name.charAt(0);
        switch (prefix)
        {
            case STANDARD:
                break;

            case DOUBLE_HAND:
                estimatedWight = 2;
                break;

            case NOT_MOVABLE:
                estimatedWight = HEAVY;
                break;

            case ALCOHOL:
                alcoholic = true;
                break;

            default:
                throw new RuntimeException(eITEM_PREFIX + prefix + '»');
//                    "\nUnknown prefix value: «" + prefix + '»');
        }
        weight      = estimatedWight;
        isAlcoholic = alcoholic;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí odkaz na obrázek daného předmětu.
     *
     * @return  Požadovaný odkaz
     */
    @Override
    public String getPicture()
    {
        return getName().toLowerCase();
    }


    /***************************************************************************
     * Returns the item weight, and/or the corresponding characteristics.
     * The items that cannot be raised
     * have higher weight than the bag capacity is.
     *
     * @return Weight of the item
     */
    @Override
    public int getWeight()
    {
        return weight;
    }


    /***************************************************************************
     * Returns information if it is the alcoholic drink.
     *
     * @return If it is the alcoholic drink, it returns {@code true},
     *         otherwise it returns {@code false}
     */
    public boolean isAlcoholic()
    {
        return isAlcoholic;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
