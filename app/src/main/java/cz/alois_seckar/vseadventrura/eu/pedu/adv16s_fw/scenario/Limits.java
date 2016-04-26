/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.scenario;



/*******************************************************************************
 * Instances of the {@code Limits} class serve as crates
 * containing the basic requirements to the happy scenario;
 * its "minimal sizes".
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class Limits
{
//== CONSTANT CLASS FIELDS =====================================================
//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================

    /** Minimal number of happy scenario steps. */
    public final int minSteps;

    /** Minimal number of game spaces. */
    public final int minSPaces;

    /** Minimal number of visited spaces. */
    public final int minVisited;

    /** Minimal number of non-standard actions. */
    public final int minOwnActions;



//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Create the crate containing the basic requirements to the happy scenario;
     * its "minimal sizes".
     *
     * @param minSteps      Minimal number of happy scenario steps
     * @param minSPaces     Minimal number of game spaces
     * @param minVisited    Minimal number of visited spaces
     * @param minOwnActions Minimal number of non-standard actions
     */
    public Limits(int minSteps, int minSPaces, int minVisited,
                  int minOwnActions)
    {
        this.minSteps      = minSteps;
        this.minSPaces     = minSPaces;
        this.minVisited    = minVisited;
        this.minOwnActions = minOwnActions;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /***************************************************************************
     * Returns the textual signature of this instance
     * containing information about the requirements.
     *
     * @return Text with description of the requirements
     */
    @Override
    public String toString()
    {
        return "Minimal requirements to the happy scenario:"
           + "\n   Minimal number of steps = "               + minSteps
           + "\n   Minimal number of game spaces = "         + minSPaces
           + "\n   Minimal number of visited spaces = "      + minVisited
           + "\n   Minimal number of non-standard actions = "+ minOwnActions;
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
