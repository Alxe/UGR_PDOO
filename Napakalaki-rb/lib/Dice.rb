# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Dice
  include Singleton
  
  def initialize
    @r = Random.new
  end
  
  def next_number
    1 + r.rand(6)
  end
end
