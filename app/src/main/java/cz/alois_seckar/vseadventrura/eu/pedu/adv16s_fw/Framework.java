/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.empty_classes.IAuthorPrototype;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGSMFactory;
import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.IGame;
//import cz.alois_seckar.vseadventrura.DefaultGSMTFactory;

import android.graphics.Point;



/*******************************************************************************
 * Knihovní třída {@code Framework} obsahuje konstanty a metody
 * sdílené různými třídami napříč aplikací.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public class Framework implements IAuthorPrototype
{
//== CONSTANT CLASS FIELDS =====================================================

    /** Framework version. */
    public static final String VERSION = "16.00.5987 — 2016-01-01";

    /** Maximální povolená délka řádku. */
    public static final int MAX_LINE_LENGTH = 80;

    /** Výchozí pozice dotazovacího okna. */
    public static final Point CONTROL_WINDOW_POSITION = new Point(1000, 000);

    /** Pozice aplikačního okna
     *  připravená práci na počítači s více monitory. */
    public static final Point START_WINDOW_POSITION = new Point(0, -00);

    /** ClassLoader definující umístění kořenového balíčku. */
    public static final ClassLoader CLASS_LOADER =
                                    Framework.class.getClassLoader();



//
//    /** Adresa složky se zdroji relativně vůči složce s kořenovým balíčkem. */
//    public static final String PATH_TO_DATA;



//== VARIABLE CLASS FIELDS =====================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//
//    static {
//        Package pkg  = Framework.class.getPackage();
//        String  path = pkg.getName().replace(".", "/");
//        PATH_TO_DATA = path + "/data/";
//    }
//
//
//
//== CLASS GETTERS AND SETTERS =================================================

    /***************************************************************************
     * Vrátí instanci implicitní hry implementující interfejs {@link IGame},
     * tj. hry předpokládající použití textového uživatelského rozhraní.
     *
     * @return Instance implicitní textové hry
     */
    public static IGSMFactory getDefaultFactory()
    {
        return null; // new DefaultGSMTFactory();
    }


    /***************************************************************************
     * Metoda vrací textový řetězec definující aktuální verzi frameworku.
     *
     * @return Řetězec definující aktuální verzi frameworku
     */
    public static String getVersion()
    {
        return VERSION;
    }



//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE FIELDS ==================================================
//== VARIABLE INSTANCE FIELDS ==================================================



//##############################################################################
//== CONSTRUCTORS AND FACTORY METHODS ==========================================

    /***************************************************************************
     * Konstruktor není definován jako soukromý, aby bylo možno definovat
     * potomka specializovaného na podporu tvorby a testování GUI.
     */
    protected Framework() {}



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
