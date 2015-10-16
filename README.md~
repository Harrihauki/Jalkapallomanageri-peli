# Jalkapallomanageri-peli

Tämä löytynee aihemäärittelyä helpommin, joten sieltä kopioitu pätkä:

"*Aihe:* Jalkapallomanageri-peli. Toteutetaan peli, jossa pelaajan tarkoitus on kehittää jalkapallojoukkuetta ja ohjata joukkueensa menestykseen. Ajatuksena on, että pelaajien taidot määrittävät pelaajien hyvyyden eri tilanteissa ja pelaajien sijoittelulla pyritään saamaan pelaajat mahdollisimman usein vahvuuksiensa mukaisiin tilanteisiin. Tilanteet perustuvat "oikean jalkapallon tavoin" 1v1 tilanteisiin, joissa yksittäisten pelaajien kyvyt ratkaisevat."

Toistaiseksi käyttöliittymää, varsinkaan graafista sellaista, ei ole ollenkaan. Mainia on käytetty lähinnä testauksen ja debuggauksen tukena, joten sieltä ei löyty mitään fiksua suoritettavaa sinänsä. Pelaaja-, Joukkue-, Muodostelma- ja Pelaaja-generaattori-luokat ovat sinne päin, Ottelu-luokassa on jonkin verran aikaansaatua, mutta aivan vaiheessa. Testauksen sentään pitäisi olla jollakin tasolla: Suurin osa vajaasta testauksesta on gettereitä ja muista triviaalimman suuntaisista metodeista johtuvia.

Ajatuksia tulevasta:

1) Pelaajageneraattori oppii esimerkiksi tiedostosta antamaan pelaajille oikeita nimiä, eikä numeroita

2) Ottelumekaniikka pohjaa pelaajien taitoihin, sijaintiin ja sattumaan: Pallollinen pelaaja jollain todennäköisyydellä joko syöttää tai lähtee harhauttamaan. Tähän vaikuttaa jonkin verran ainakin pelaajan pelipaikka, eli kuinka korkealla on pelikentällä. Syötön kohteeksi valikoitumiseen ja syötön onnistumiseen vaikuttavat myös etäisyydet: Mitä lähempänä oma pelaaja on, sitä todennäköisemmin pallollinen pelaaja syöttää kyseiselle pelaajalle ja sitä todennäköisemmin syöttö onnistuu. Vastaavasti pidemmästä syötöstä oma pelaaja pääsee useammin maalintekotilanteeseen. Syötön onnistumiseen vaikuttavat myös ainakin syöttäjän syöttötaidon ja vastaanottajan sijoittumistaidon suhde vastassa olevan pelaajan puolustus- ja sijoittumis-taitoon. Samoin harhauttamisessa vaikuttavat hyökkääjän ja puolustajan taitojen suhteet, maalinteossa hyökkääjän ja maalivahdin taitojen suhteet, jne. Myös pelaajan sijainti kentällä vaikuttaa siihen, kuinka usein hänen syötöstään tai harhautuksestaan seuraa maalipaikka. Avainasemassa on siis aina pallollinen pelaaja.

3) Käyttöliittymä pitäisi saada rakennettua..
