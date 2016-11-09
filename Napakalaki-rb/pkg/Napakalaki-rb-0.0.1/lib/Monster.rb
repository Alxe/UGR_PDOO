# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'Prize.rb'
require_relative 'BadConsequence.rb'
require_relative 'TreasureKind.rb'

class Monster
  attr_accessor :name, :combatLevel, :prize, :bc
  
  def initialize(name, combatLevel, prize, bc)
    @name = name
    @combatLevel = combatLevel
    @prize = prize
    @bc = bc
  end
  
  def to_s
    "Monster{name=#{@name}, combatLevel=#{@combatLevel}, prize=#{@prize}, bc=#{@bc}}"
  end
end
