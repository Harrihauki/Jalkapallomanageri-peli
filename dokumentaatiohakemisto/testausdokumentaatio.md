Testauksen ulkopuolelle jätettiin kokonaan pakkaukset:

- Käyttöliittymä
- Kello
- pelaajaGeneraattori

Käyttöliittymää ei ohjeiden mukaan kuulunutkaan testata automaattisesti. Käytössä huomatut viat - kuten virheelliset tulosteet, toimimattomat napit jne - on korjattu, jos niitä on löydetty.

Kello on suoraan kopioitu OhPessa keväällä tekemästäni kellosta. Tuskin vaatii sen isompaa testaamista, kun meni silloinkin testeistä läpi.

pelaajaGeneraattorissa kaikki toiminta on puhtaasti satunnaisuutta ja suuruusvertailua. Toiminnassa ei ole näkynyt kummallisuuksia käytön aikana, vaan arvot ovat olleet tarkoitetuissa rajoissa.

Rivikattavuus- ja mutaatio-testien rajoja vetävät alas ennen kaikkea ottelulogiikan metodit. Näistä monet ovat gettereitä ja settereitä, joita ei ollut tarkoitus testata, sekä vielä suurempi osa satunnaisuutta, jota on vaikea testata automaattisesti. Härskejä erikoisuuksia ei ole käytössä ilmennyt. Lisäksi suurimman osan muistakin luokista vajavaisuudet ovat peräisin gettereistä ja yksinkertaisista lasku- ja vertailutoimituksista. Käytössä ei isompaa ongelmia näidenkään kohdalla ole löytynyt.

Isoja bugeja ei enää tiedossa.
