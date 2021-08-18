INSERT INTO author (id, full_name) VALUES (2, 'Douglas Adams');
INSERT INTO author (id, full_name) VALUES (3, 'Stephen King');
INSERT INTO author (id, full_name) VALUES (4, 'Marc-Uwe Kling');
INSERT INTO author (id, full_name) VALUES (5, 'Sebastian Fitzek');
INSERT INTO author (id, full_name) VALUES (6, 'J. R. R. Tolkien');
INSERT INTO author (id, full_name) VALUES (7, 'Terry Pratchett');

#Scheibenwelt
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (1, 2, 7, 'Die Farben der Magie', '1983-11-24',
    'Die Farben der Magie handelt von der Begegnung des magisch minderbegabten Zauberers Rincewind mit Zweiblum, 
     dem ersten Touristen der Scheibenwelt. Der Patrizier verdonnert Rincewind, dem Fremdling vom Gegengewichtskontinent 
     als Reiseführer und Übersetzer zu dienen. Widerwillig, aber bestärkt durch die Aussicht auf ein fürstliches Honorar, 
     nimmt er den Auftrag an. Nachdem Zweiblum, im Hauptberuf Risikoanalyst einer Versicherung, Ankh-Morpork mit der 
     innovativen Idee der Feuerversicherungspolice vertraut gemacht hat, brennt die Stadt, nicht ganz überraschend, komplett nieder.
     Damit beginnt die gemeinsame, gefahrvolle Reise durch die ländlichen Regionen der Scheibenwelt.',
     10, 7, 256, 'https://assets.thalia.media/img/artikel/4ad20186dd9921645aaca38dceac23e9300e1be1-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (2, 2, 7, 'Das Licht der Fantasie', '1986-06-02',
    'Ein Fichtenstamm bewahrt den ungeschickten Rincewind vor dem Absturz vom Rand 
    der Scheibenwelt. Der Zauberer findet sich in einem von intelligenten Bäumen bevölkerten Wald wieder und trifft erneut auf 
    den Touristen Zweiblum. Währenddessen droht der Planet von einem roten Stern verschlungen zu werden. Nur ein Zauberspruch 
    kann die Scheibenwelt noch retten, doch der befindet sich ausgerechnet in Rincewinds Kopf … ',
    10, 8, 288, 'https://assets.thalia.media/img/artikel/6d21b50856b312e5e57e64fe8de8442734e25d8c-00-00.jpeg');


#Per Anhalter durch die Galaxis
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (10, 1, 2, 'Per Anhalter durch die Galaxis', '1979-10-12',
    'Eines normalen Tages erfährt Arthur Dent zufällig, dass die Zerstörung der Erde unmittelbar bevorsteht: Sie soll einer 
    Hyperraumumgehungsstraße weichen. Zum Glück entpuppt sich sein bester Freund als Außerirdischer, der sie per Anhalter auf ein 
    Raumschiff schleust und so rettet. Zumindest erst mal. Denn bevor sie die Antwort auf die Frage nach dem Leben, dem Universum und 
    dem ganzen Rest erfahren, müssen sie gemeinsam mit dem debilen Präsidenten der Galaxis und einem schwermütigen Roboter den 
    unwahrscheinlichsten Planeten überleben, den es je gab. Der erste Band der intergalaktischen Kult-Serie "Per Anhalter durch die Galaxis".',
    12, 7, 240, 'https://assets.thalia.media/img/artikel/6d442ab10a56a88135143126b1a9afa750298c93-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (11, 1, 2, 'Das Restaurant am Ende des Universums', '1980-10-01',
    'Seitdem die Erde einer intergalaktischen Umgehungsstraße weichen musste, befindet sich Arthur Dent auf einer verwirrenden Odyssee 
    durch das Universum. Wieso zieht es ihn und seine Freunde immer an die übelsten Orte der Galaxis? Weshalb haben die Fahrstühle eigentlich
     einen Hang zum Existenzialismus? Und warum müssen die Reisenden ausgerechnet im Restaurant am Ende des Universums einkehren, 
     eine der außergewöhnlichsten Unternehmungen in der gesamten Geschichte des Gaststättengewerbes? Der zweite Band der intergalaktischen 
     Kult-Serie »Per Anhalter durch die Galaxis«.',
     12, 8, 272, 'https://assets.thalia.media/img/artikel/015e0128d7d640b959b91c53182b80c74bab3254-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (12, 1, 2, 'Das Leben, das Universum und der ganze Rest', '1982-08-01',
    'Infolge einer Reihe von atemberaubenden Katastrophen findet sich Arthur Dent überraschenderweise in einer schrecklich primitiven Höhle 
    auf der prähistorischen Erde wieder. Am richtigen Ort, nur leider zur falschen Zeit, und die Zeit ist schließlich der ungeeignetste Ort, 
    an dem man verloren gehen kann. Um wieder zurück in die Weiten der Galaxis zu gelangen, sind er und Ford Prefect angewiesen auf Slartibartfass. 
    Doch als Arthur einen intergalaktischen Krieg unterbinden soll und den Freunden allmählich klar wird, in welche Abenteuer sie sich da gestürzt 
    haben, wünschen sie sich wieder zurück in ihre Steinzeithöhle. Der dritte Band der intergalaktischen Kult-Serie »Per Anhalter durch die Galaxis«.',
    12, 7, 256, 'https://assets.thalia.media/img/artikel/8c643c95ee5a099ba1759484475539b6237c4b6e-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (13, 1, 2, 'Macht''s gut und danke für den Fisch', '1984-01-01',
    'Arthur Dent hat genug vom All und kehrt, nachdem sein explodierter Heimatplanet auf wundersame Weise wieder existiert, in sein altes Leben zurück.
     Die Menschen gehen dort wie immer ihren Gewohnheiten nach, und auch sein Haus steht noch. Nur Fenchurch, das Mädchen mit der zündenden Idee, kann 
     sich erinnern, dass die Vogonen die Erde zerstört haben. Und sie weiß auch, worin der Sinn des Lebens besteht. Zumindest wusste sie es – jetzt hat 
     sie es leider wieder vergessen. Der vierte Band der intergalaktischen Kult-Serie »Per Anhalter durch die Galaxis«.',
     12, 6, 224, 'https://assets.thalia.media/img/artikel/7163a2f004d16b2a9b64a73ada08705174a0b18a-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (14, 1, 2, 'Einmal Rupert und zurück', '1992-01-01',
    'In einem Paralleluniversum wird Tricia McMillan von den grebulonischen Forschern auf den Planeten Rupert entführt. Die Grebulonier haben allesamt 
    ihr Gedächtnis verloren und wissen nicht mehr, warum sie in das Sonnensystem der Erde aufgebrochen sind. Um ein Horoskop zu erstellen, das auch für 
    Rupert gültig ist, schicken sie die intergalaktische Reporterin Trillian los. Gemeinsam mit Arthur Dent und Ford Prefect sausen sie kreuz und quer durchs 
    Universum, wobei Arthur ohne sein Zutun Vater wird, Ford Elvis Presley ein rosafarbenes Raumschiff abkauft und Trillian den Grebuloniern ein Sonnensystem 
    errichtet. Der fünfte Band der intergalaktischen Kult-Serie »Per Anhalter durch die Galaxis«.',
    12, 9, 320, 'https://assets.thalia.media/img/artikel/dd22805cb7ed602b54289337bb3e148ec8ae7f07-00-00.jpeg');


#Känguru Chroniken
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (15, 3, 4, 'Die Känguru-Chroniken', '2009-03-11',
    '»Ich bin ein Känguru - und Marc-Uwe ist mein Mitbewohner und Chronist. Nur manches, was er über mich erzählt, stimmt. 
    Zum Beispiel, dass ich mal beim Vietcong war. Das Allermeiste jedoch ist übertrieben, verdreht oder gelogen! Aber ich darf nicht meckern. 
    Wir gehen zusammen essen und ins Kino, und ich muss nix bezahlen.« Mal bissig, mal verschroben, dann wieder liebevoll ironisch wird der Alltag 
    eines ungewöhnlichen Duos beleuchtet. Völlig absurd und ein großer Lesespaß.',
    10, 8, 272, 'https://assets.thalia.media/img/artikel/154079d4058177b17311d9e33fb92f820a24c67e-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (16, 3, 4, 'Das Känguru-Manifest', '2011-08-12',
    'Sie sind wieder da – das kommunistische Känguru und der stoische Kleinkünstler! Auf der Jagd nach dem höchstverdächtigen Pinguin rasen sie durch 
    die ganze Welt. Spektakuläre Enthüllungen! Skandale! Intrigen! Ein Mord, für den sich niemand interessiert! Eine Verschwörung auf niedrigster Ebene! 
    Ein völlig abstruser Weltbeherrschungsplan! Mit Spaß, Spannung und Schnapspralinen ...',
    10, 9, 302, 'https://assets.thalia.media/img/artikel/f484890bb1352c68a0c7b48c28b76bc293b8744a-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (17, 3, 4, 'Die Känguru-Offenbarung', '2014-03-10',
    'Endlich: Es geht weiter! Nach dem Manifest folgt die Offenbarung! Hier kommt die fulminante Fortsetzung der Fortsetzung: Das Beuteltier und der Kleinkünstler
     auf der Jagd nach dem mysteriösen Pinguin. Haltet euch bereit: »Dies ist die Offenbarung des Kängurus, dem Asozialen Netzwerk zu zeigen, was in der Kürze geschehen 
     soll; und sie wurde gesandt durch eine E-Mail zu seinem Knecht Marc-Uwe, der bezeugt hat das Wort des Kängurus und das Zeugnis vom Asozialen Netzwerk, was er 
     gesehen hat. Selig ist, der da liest und die da hören die Worte der Weissagung, denn die Zeit ist nahe.« Halleluja. ',
    12, 12, 400, 'https://assets.thalia.media/img/artikel/dd9424ce90c354c441d4ccd515e4348dc76bd5e6-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (18, 3, 4, 'Die Känguru-Apokryphen', '2018-10-12',
    'Sensation, Sensation: Archäologen haben in einem Geheimfach in Marc-Uwes Schreibtisch neue Geschichten vom Känguru und seinem Kleinkünstler gefunden! 
    Dies ist nicht die Fortsetzung der Fortsetzung der Fortsetzung der Känguru-Chroniken. Triologie bleibt Triologie. Aber ein anständiger Kleinkünstler hat 
    natürlich eine Zugabe vorbereitet.',
    12, 6, 208, 'https://assets.thalia.media/img/artikel/258986897954caaaf091889849160ab18a6cf1c3-00-00.jpeg');


#Sebastian Fitzek Romane
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (19, 3, 5, 'Der Seelenbrecher', '2008-10-01',
    'Drei Frauen – alle jung, schön und lebenslustig – verschwinden spurlos. Nur eine Woche in den Fängen des Psychopathen, den die Presse den ›Seelenbrecher‹ nennt, 
    genügt: Als man die Frauen wieder aufgreift, sind sie verwahrlost, psychisch gebrochen – wie lebendig in ihrem eigenen Körper begraben. Kurz vor Weihnachten wird 
    der Seelenbrecher wieder aktiv, ausgerechnet in einer psychiatrischen Luxusklinik. Ärzte und Patienten müssen entsetzt feststellen, dass man den Täter unerkannt 
    eingeliefert hat, kurz bevor die Klinik durch einen Schneesturm völlig von der Außenwelt abgeschnitten wurde. Verzweifelt versuchen die Eingeschlossenen einander 
    zu schützen – doch in der Nacht des Grauens, die nun folgt, zeigt der Seelenbrecher, dass es kein Entkommen gibt ...',
    16, 9, 360, 'https://assets.thalia.media/img/artikel/21cee4b0a4ef422d2fc858785dee2c2e46545b69-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (20, 3, 5, 'Passagier 23', '2014-10-30', 
    'Jedes Jahr verschwinden auf hoher See rund 20 Menschen spurlos von Kreuzfahrtschiffen. Noch nie kam jemand zurück. Bis jetzt ... Martin Schwartz, Polizeipsychologe, 
    hat vor fünf Jahren Frau und Sohn verloren. Es geschah während eines Urlaubs auf dem Kreuzfahrtschiff Sultan of the Seas niemand konnte ihm sagen, was genau geschah. 
    Martin ist seither ein psychisches Wrack und betäubt sich mit Himmelfahrtskommandos als verdeckter Ermittler. Mitten in einem Einsatz bekommt er den Anruf einer 
    seltsamen alten Dame, die sich als Thrillerautorin bezeichnet: Er müsse unbedingt an Bord der Sultan kommen, es gebe Beweise dafür, was seiner Familie zugestoßen 
    ist. Nie wieder wollte Martin den Fuß auf ein Schiff setzen und doch folgt er dem Hinweis und erfährt, dass ein vor Wochen auf der Sultan verschwundenes Mädchen 
    wieder aufgetaucht ist. Mit dem Teddy seines Sohnes im Arm ...',
    16, 10, 432, 'https://m.media-amazon.com/images/I/51TKJl9xpBL.jpg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (21, 3, 5, 'Der Heimweg', '2020-10-21',
    'Es ist Samstag, kurz nach 22.00 Uhr. Jules Tannberg sitzt am Begleittelefon. Ein ehrenamtlicher Telefonservice für Frauen, die zu später Stunde auf ihrem Heimweg 
    Angst bekommen und sich einen telefonischen Begleiter wünschen, dessen beruhigende Stimme sie sicher durch die Nacht nach Hause führt - oder im Notfall Hilfe ruft.
    Noch nie gab es eine wirklich lebensgefährliche Situation. Bis heute, als Jules mit Klara spricht. Die junge Frau hat entsetzliche Angst. Sie glaubt, von einem Mann 
    verfolgt zu werden, der sie schon einmal überfallen hat und der mit Blut ein Datum auf ihre Schlafzimmerwand malte: Klaras Todestag! Und dieser Tag bricht in nicht 
    einmal zwei Stunden an ...',
    16, 10, 400, 'https://assets.thalia.media/img/artikel/a5911afe2bb5d968547848aa7deea909bc172170-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (22, 3, 5, 'Die Therapie', '2006-07-01',
    'Keine Zeugen, keine Spuren, keine Leiche. Josy, die 12-jährige Tochter des bekannten Psychiaters Viktor Larenz, verschwindet unter mysteriösen Umständen. Ihr 
    Schicksal bleibt ungeklärt. Vier Jahre später: Der trauernde Viktor hat sich in ein abgelegenes Ferienhaus zurückgezogen. Doch eine schöne Unbekannte spürt ihn 
    dort auf. Sie wird von Wahnvorstellungen gequält. Darin erscheint ihr immer wieder ein kleines Mädchen, das ebenso spurlos verschwindet wie einst Josy. Viktor 
    beginnt mit der Therapie, die mehr und mehr zum dramatischen Verhör wird …',
    16, 6, 270, 'https://m.media-amazon.com/images/I/41KY5X1TXKL.jpg');


#Herr der Ringe
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (23, 2, 7, 'Der Herr der Ringe - Die Gefährten', '1954-07-29',
    'Der Schauplatz des Herrn der Ringe ist Mittelerde, eine alternative Welt, und erzählt wird von der gefahrvollen Quest einiger Gefährten, die in einem 
    dramatischen Kampf gegen das Böse endet. Durch einen merkwürdigen Zufall fällt dem Hobbit Bilbo Beutlin ein Zauberring zu, dessen Kraft, käme er in die 
    falschen Hände, zu einer absoluten Herrschaft des Bösen führen würde. Bilbo übergibt den Ring an seinen Neffen Frodo, der den Ring in der Schicksalskluft 
    zerstören soll. ',
    12, 15, 608, 'https://assets.thalia.media/img/artikel/f65aed64c4b51d0045d84f2eb74abc930422ae9f-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (24, 2, 7, 'Der Herr der Ringe - Die zwei Türme', '1954-11-11',
    'Durch einen merkwürdigen Zufall fällt dem Hobbit Bilbo Beutlin ein Zauberring zu, dessen Kraft, käme er in die falschen Hände, zu einer absoluten Herrschaft 
    des Bösen führen würde. Bilbo übergibt den Ring an seinen Neffen Frodo, der den Ring in der Schicksalskluft zerstören soll.',
    12, 13, 510, 'https://assets.thalia.media/img/artikel/7a59a3fa9dd6cd771be018a54b571c6c9b5a1063-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (25, 2, 7, 'Der Herr der Ringe - Die Rückkehr des Königs', '1955-10-20',
    'Der Schauplatz des Herrn der Ringe ist Mittelerde, eine alternative Welt, und erzählt wird von der gefahrvollen Quest einiger Gefährten, die in einem dramatischen 
    Kampf gegen das Böse endet. Durch einen merkwürdigen Zufall fällt dem Hobbit Bilbo Beutlin ein Zauberring zu, dessen Kraft, käme er in die falschen Hände, zu einer 
    absoluten Herrschaft des Bösen führen würde. Bilbo übergibt den Ring an seinen Neffen Frodo, der den Ring in der Schicksalskluft zerstören soll. Hobbits sind kleine, 
    gemütliche Leute, dabei aber erstaunlich zäh. Sie leben in einem ländlichen Idyll, dem Auenland.',
    12, 11, 444, 'https://assets.thalia.media/img/artikel/726e0e43a42aa0b11b9392354c83293c63b504d2-00-00.jpeg');
INSERT INTO book (id, setting_id, author_id, title, publishing_year, description, min_age, duration, page_count, image_url)
  VALUES (26, 2, 7, 'Der kleine Hobbit', '1937-09-21',
    'Vorbei ist es mit dem beschaulichen Leben von Bilbo Beutlin, seit er sich auf ein Abenteuer eingelassen hat, das Hobbitvorstellungen bei Weitem übersteigt. Nicht nur, 
    dass er sich auf eine Reise von der Dauer eines Jahres begibt, die ihn quer durch Mittelerde führen wird, er lässt sich auch vom Zwergenkönig als Meisterdieb unter 
    Vertrag nehmen und verpflichtet sich, den Zwergen bei der Rückgewinnung ihres geraubten Schatzes zu helfen. Auf seiner abenteuerlichen Reise gelangt Bilbo in den 
    Besitz des Ringes, den er später an seinen Neffen Frodo weitergibt – die Grundlage für die legendäre Trilogie um den »Einen Ring«. ',
    10, 8, 336, 'https://assets.thalia.media/img/artikel/2ed333f19236057bade45d68519bd3adac996c2b-00-00.jpeg');

INSERT INTO book2book_genre (book_id, book_genre_id) VALUES (1,3), (1,4), (2,3), (2,4);
INSERT INTO book2activity_type (book_id, activity_type_id) VALUES (1,1), (1,5), (2,1), (2,5);
INSERT INTO book2book_genre (book_id, book_genre_id) VALUES (10,4), (10,6), (11,4), (11,6), (12,4), (12,6), (13,4), (13,6), (14,4), (14,6);
INSERT INTO book2activity_type (book_id, activity_type_id) VALUES (10,5), (11,5), (12,5), (13,5), (14,5);
INSERT INTO book2book_genre (book_id, book_genre_id) VALUES (15,6), (16,6), (17,6), (17,3), (18,6);
INSERT INTO book2activity_type (book_id, activity_type_id) VALUES (15,5), (16,5), (17,5), (18,5), (17,6);
INSERT INTO book2book_genre (book_id, book_genre_id) VALUES (19,1), (20,1), (21,1), (22,1);
INSERT INTO book2activity_type (book_id, activity_type_id) VALUES (19,3), (20,3), (21,3), (22,3), (19,6), (20,6), (21,6), (22,6);
INSERT INTO book2book_genre (book_id, book_genre_id) VALUES (23,4), (23,3), (24,4), (24,3), (25,4), (25,3), (26,4), (26,3);
INSERT INTO book2activity_type (book_id, activity_type_id) VALUES (23,4), (23,6), (24,4), (24,6), (25,4), (25,6), (26,4), (26,6);