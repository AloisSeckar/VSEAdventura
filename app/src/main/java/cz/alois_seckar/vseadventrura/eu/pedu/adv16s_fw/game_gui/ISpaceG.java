/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_gui;

import cz.alois_seckar.vseadventrura.eu.pedu.adv16s_fw.game_txt.ISpace;

import android.graphics.Point;
import java.util.Collection;



/*******************************************************************************
 * Instance interfejsu {@code ISpaceG} přestavují místnosti či jejich
 * ekvivalenty. Dosažení místnosti si můžeme představovat jako částečný cíl,
 * kterého se hráč ve hře snaží dosáhnout.
 * Místnosti mohou obsahovat různé předměty,
 * které mohou hráči pomoci v dosažení cíle hry.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2016-Summer
 */
public interface ISpaceG
         extends ISpace, IItemContainerG
{
//== STATIC CONSTANTS ==========================================================
//== STATIC METHODS ============================================================



//##############################################################################
//== ABSTRACT GETTERS AND SETTERS ==============================================

    /***************************************************************************
     * Vrátí pozici místnosti na plánu hry,
     * přesněji pozici hráče nacházejícího se v dané místnosti.
     * Na této pozici bude hráč při pobytu v dané místnosti zobrazen.
     *
     * @return Požadovaná pozice
     */
//    @Override
    public Point getPosition();


    //Metody místností implementujících tento interfejs musejí vracet
    //kolekce instancí implementujících interfejs {@link IItemG}
    //Proto je třeba je tu deklarovat znovu. protože původně deklarované
    //návratové hodnoty jsou potomky návratových hodnot metod jeho rodiče


    /***************************************************************************
     * Vrátí kolekci prostorů, do nichž je možno se z tohoto prostoru přesunout.
     *
     * @return Požadovaná kolekce
     */
    @Override
    public Collection<? extends ISpaceG> getNeighbors()
    ;

    // rozšíření - obrázek místnosti
    public String getPicture();



//== OTHER ABSTRACT METHODS ====================================================
//== DEFAULT GETTERS AND SETTERS ===============================================
//== OTHER DEFAULT METHODS =====================================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
