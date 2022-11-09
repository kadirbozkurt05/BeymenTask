Feature: Proje Ödevi

  Scenario: Sepet İşlemleri
    Given www.beymen.com sitesi açılır.
    Then Ana sayfanın açıldığı kontrol edilir.
    And Arama kutucuğuna “şort” kelimesi girilir.
    And Arama kutucuğuna girilen “şort” kelimesi silinir.
    And Arama kutucuğuna “gömlek” kelimesi girilir.
    And Klavye üzerinden “enter” tuşuna bastırılır
    And Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
    And Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
    And Seçilen ürün sepete eklenir.
    And Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
    And Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
    And Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.