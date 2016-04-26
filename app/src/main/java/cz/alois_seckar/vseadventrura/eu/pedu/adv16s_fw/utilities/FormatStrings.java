/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.utilities;



/*******************************************************************************
 * Instance třídy {@code FormatStrings} představují ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class FormatStrings
{
//== CONSTANT CLASS FIELDS =====================================================

    public static final char NL = '\n';

    public static final String

    LINE =
"-----------------------------------------------------------------------------",

    DOUBLELINE =
"=============================================================================",

    HASHES =
"#############################################################################",

    CIRCUMFLEXES =
"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^",

    /** Oddělovač vypisovaný před vlastní chybovou zprávou. */
    BERFORE =
"VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV",

    /** Oddělovač vypisovaný za vlastní chybovou zprávou. */
    AFTER =
"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",

    LINE_N   =        LINE + '\n',
    N_LINE   = '\n' + LINE,
    N_LINE_N = '\n' + LINE + '\n',
    LINE_ARG =        LINE + "%s\n",

    DOUBLELINE_N    =          DOUBLELINE + '\n',
    N_DOUBLELINE    =   '\n' + DOUBLELINE,
    N_DOUBLELINE_N  =   '\n' + DOUBLELINE + '\n',
    NN_DOUBLELINE   = "\n\n" + DOUBLELINE,
    NN_DOUBLELINE_NN= "\n\n" + DOUBLELINE + "\n\n",

    HASHES_N   =        HASHES + '\n',
    N_HASHES   = '\n' + HASHES,
    N_HASHES_N = '\n' + HASHES + '\n',

    CIRCUMFLEXES_N   =        CIRCUMFLEXES + '\n',
    N_CIRCUMFLEXES   = '\n' + CIRCUMFLEXES,
    N_CIRCUMFLEXES_N = '\n' + CIRCUMFLEXES + '\n',

    BERFORE_N   =        BERFORE + '\n',
    N_BERFORE   = '\n' + BERFORE,
    N_BERFORE_N = '\n' + BERFORE + '\n',

    AFTER_N   =        AFTER + '\n',
    N_AFTER   = '\n' + AFTER,
    N_AFTER_N = '\n' + AFTER + '\n',

    EMPTY_STRING=""; //Abych nemusel přemýšlet nad čárkami



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private FormatStrings() {}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
