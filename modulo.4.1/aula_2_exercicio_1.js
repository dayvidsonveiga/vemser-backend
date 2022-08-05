use vem_ser
db.alunos.insertMany([
    {
        "nome": "Dayvidson Veiga",
        "data_nascimento": new Date(1982,1,29)
    },
    {
        "nome": "Tasia Peixoto",
        "data_nascimento": new Date(1982,8,30)
    },
    {
        "nome": "Maria Luiza",
        "data_nascimento": new Date(1955,1,25)
    }])

db.alunos.find(
    {
        "nome": "Dayvidson Veiga"
    }
).pretty()  
// tem que estar exatamente como foi passado.

db.alunos.find({
    "nome":{$regex:/el/}
  })    
// contem este trecho.

db.alunos.find({
    "data_nascimento": {$gte:new Date(2012,1,1)},
})      
// datas de nascimento mais recentes q essa data.

db.alunos.find({
    "data_nascimento": {$lte:new Date(2012,1,1)},
})      
// datas de nascimento mais antigas q essa data.