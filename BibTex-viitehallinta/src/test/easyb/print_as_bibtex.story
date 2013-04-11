description 'User can print books/..s/..s as bibtex'

scenario "user can print books in bibtex", {
    given 'Kirjojen listaus selected'
    when 'link is pressed'
    then 'books are printed in bibtex'
          
}